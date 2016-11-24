from sqlalchemy import *

# Let's re-use the same database as before
db = create_engine('sqlite:///tutorial.db')

db.echo = True  # We want to see the SQL we're creating

metadata = BoundMetaData(db)

# The users table already exists, so no need to redefine it. Just
# load it from the database using the "autoload" feature.
users = Table('users', metadata, autoload=True)

def run(stmt):
    rs = stmt.execute()
    for row in rs:
        print row

# Most WHERE clauses can be constructed via normal comparisons
s = users.select(users.c.name == 'John')
run(s)
s = users.select(users.c.age < 40)
run(s)

# Python keywords like "and", "or", and "not" can't be overloaded, so
# SQLAlchemy uses functions instead
s = users.select(and_(users.c.age < 40, users.c.name != 'Mary'))
run(s)
s = users.select(or_(users.c.age < 40, users.c.name != 'Mary'))
run(s)
s = users.select(not_(users.c.name == 'Susan'))
run(s)

# Or you could use &, | and ~ -- but watch out for priority!
s = users.select((users.c.age < 40) & (users.c.name != 'Mary'))
run(s)
s = users.select((users.c.age < 40) | (users.c.name != 'Mary'))
run(s)
s = users.select(~(users.c.name == 'Susan'))
run(s)

# There's other functions too, such as "like", "startswith", "endswith"
s = users.select(users.c.name.startswith('M'))
run(s)
s = users.select(users.c.name.like('%a%'))
run(s)
s = users.select(users.c.name.endswith('n'))
run(s)

# The "in" and "between" operations are also available
s = users.select(users.c.age.between(30,39))
run(s)
# Extra underscore after "in" to avoid conflict with Python keyword
s = users.select(users.c.name.in_('Mary', 'Susan'))
run(s)

# If you want to call an SQL function, use "func"
s = users.select(func.substr(users.c.name, 2, 1) == 'a')
run(s)

# You don't have to call select() on a table; it's got a bare form
s = select([users], users.c.name != 'Carl')
run(s)
s = select([users.c.name, users.c.age], users.c.name != 'Carl')
run(s)

# This can be handy for things like count()
s = select([func.count(users.c.user_id)])
run(s)
# Here's how to do count(*)
s = select([func.count("*")], from_obj=[users])
run(s)