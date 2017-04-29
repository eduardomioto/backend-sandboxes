from sqlalchemy import *

db = create_engine('sqlite:///joindemo.db')
db.echo = True
metadata = BoundMetaData(db)
users = Table('users', metadata, autoload=True)
emails = Table('emails', metadata, autoload=True)
session = create_session()

# Let's give our User and Email classes a little more smarts
class User(object):
    def __init__(self, name=None, age=None, password=None):
        self.name = name
        self.age = age
        self.password = password
    def __repr__(self):
        return self.name
class Email(object):
    def __init__(self, address=None):
        self.address = address
    def __repr__(self):
        return self.address

# Here we look at several alternate ways to do the same thing. Try
# running this program multiple times, enabling a different one of
# these code blocks each time.

# Let's look at several ways to do one-to-many relationships.

# We create the Email mapper first...
emailmapper = mapper(Email, emails)
# ... so that we can use it in the User mapper
usermapper = mapper(User, users, properties={
    'emails': relation(emailmapper),  # Here's where the magic happens
})
mary = session.query(User).get_by(name='Mary')
print mary.emails

# If we try to create multiple mappers associated with a single data
# class, we have to specify which one is the "primary" mapper associated
# with the class. Since we're demonstrating how to create one-to-many
# relationships in multiple different ways, it's simplest to just clear
# all the mappers and start over.
clear_mappers()


# We could also use the data class instead of the mapper as the parameter
# to relation()
emailmapper = mapper(Email, emails)
usermapper = mapper(User, users, properties={
    'emails': relation(Email),
})
mary = session.query(User).get_by(name='Mary')
print mary.emails

clear_mappers()


# In fact, we don't really need to keep a reference to the mapper object
# around at all. Under most circumstances, we can just throw away the
# object returned by mapper(). SQLAlchemy keeps track of a data class's
# primary mapper behind the scenes, so we don't need to hold a reference
# to it.
mapper(Email, emails)
mapper(User, users, properties={
    'emails': relation(Email),
})
mary = session.query(User).get_by(name='Mary')
print mary.emails

clear_mappers()


# Notice that the order in which you create the mappers can be important.
# If you want to call relation(), you need to pass it a class that's
# already been mapped to a database table, or else SQLAlchemy won't be
# able to figure out which table the ForeignKey relationships should refer
# to. (Remember: "In the face of ambiguity, refuse the temptation to guess.")
try:
    usermapper = mapper(User, users, properties={
        'emails': relation(Email),
    })
except exceptions.InvalidRequestError:
    print "Ignoring the deliberately-provoked error and moving on..."

clear_mappers()


# What if we also want a "user" property on the Email class? Here's one
# way to do it.
emailmapper = mapper(Email, emails)  # Save the mapper, to use it later
usermapper = mapper(User, users, properties={
    'emails': relation(Email),
})
# Now that the User mapper has been created, we can use it in a call
# to relation()
emailmapper.add_property('user', relation(User))
john = session.query(User).get_by(name='John')
print john.emails
carl_address = session.query(Email).get_by(address='carl@nospam.net')
print carl_address.user

clear_mappers()


# There's a handy "backref" feature that will do the above for you
emailmapper = mapper(Email, emails)
usermapper = mapper(User, users, properties={
    'emails': relation(Email, backref='user'),
})
# No need to call add_property(), it's already been done
john = session.query(User).get_by(name='John')
print john.emails
carl_address = session.query(Email).get_by(address='carl@nospam.net')
print carl_address.user

clear_mappers()


# Order doesn't actually matter when you use backref: you can create the
# "one" side of the one-to-many relationship first, or the "many" side of
# the one-to-many relationship first, whichever way seems more natural
# to you.
usermapper = mapper(User, users)
emailmapper = mapper(Email, emails, properties={
    'user': relation(User, backref='emails'),
})
john = session.query(User).get_by(name='John')
print john.emails
carl_address = session.query(Email).get_by(address='carl@nospam.net')
print carl_address.user

clear_mappers()


# If you've created a relation(), you can now use object references
# instead of object ID's to manage the relationship, and it all works
# just like you'd expect it to work.
emailmapper = mapper(Email, emails)
usermapper = mapper(User, users, properties={
    'emails': relation(Email, backref='user'),
})

harry = User(name='Harry', age=47)
em1 = Email('harry@nowhere.com')
em2 = Email('harry@example.org')
em1.user = harry  # Properly updates the harry.emails property
harry.emails.append(em2)  # Properly sets em2.user
# Let's prove that harry.emails and em2.user were properly set
print em2.user
print harry.emails

session.save(harry)
session.flush()

clear_mappers()


# Finally, let's demonstrate some other clever features
emailmapper = mapper(Email, emails)
usermapper = mapper(User, users, properties={
    'emails': relation(Email, backref='user'),
})

# If a relation has been defined, then get_by and select_by calls
# can do the correct joins automatically
print session.query(User).get_by(address='mary@example.com')
print session.query(Email).select_by(age=42)
# This will only work if the column you're looking for is *not*
# present in the "original" class, but is present in one of its
# relations. For example, the following does *not* do a join to the
# User table, but gets the user_id value from the Email table. Notice
# the difference in the SQL that's printed.
print session.query(Email).select_by(user_id=2)