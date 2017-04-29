from sqlalchemy import *
db = create_engine('sqlite:///keywords.db')
db.echo = True
metadata = BoundMetaData(db)
session = create_session()

articles = Table('articles', metadata,
    Column('article_id', Integer, primary_key = True),
    Column('headline', String(150)),
    Column('body', String),
)

keywords = Table('keywords', metadata,
    Column('keyword_id', Integer, primary_key = True),
    Column('keyword_name', String(50)),
)

association = Table('articles_keywords', metadata,
    Column('keyword_id', Integer, ForeignKey('articles.article_id')),
    Column('article_id', Integer, ForeignKey('keywords.keyword_id')),
)

# Handy feature: create all the tables with one function call
metadata.create_all()

class Article(object):
    def __init__(self, headline=None, body=None):
        self.headline = headline
        self.body = body
    def __repr__(self):
        return 'Article %d: "%s"' % (self.article_id, self.headline)

class Keyword(object):
    def __init__(self, name=None):
        self.keyword_name = name
    def __repr__(self):
        return self.keyword_name

# To create a many-to-many relation, specify the association table as
# the "secondary" keyword parameter to mapper()
mapper(Article, articles)
mapper(Keyword, keywords, properties = {
    'articles': relation(Article, secondary=association, backref='keywords'),
})

a1 = Article(headline="Python is cool!", body="(to be written)")
a2 = Article(headline="SQLAlchemy Tutorial", body="You're reading it")
session.save(a1)
session.save(a2)

k_tutorial = Keyword('tutorial')
k_cool = Keyword('cool')
k_unfinished = Keyword('unfinished')

a1.keywords.append(k_unfinished)
k_cool.articles.append(a1)
k_cool.articles.append(a2)
# Or:
k_cool.articles = [a1, a2]  # This works as well!
a2.keywords.append(k_tutorial)

# Now we write all this out to the database in one single step, and
# SQLAlchemy automatically figures out the correct order for the SQL
# statements. Notice also how we didn't need to save the Keyword
# instances, because a dependency relationship was set up when we
# associated them with their articles just now.
session.flush()

print a1, a1.keywords
print a2, a2.keywords
print k_tutorial, k_tutorial.articles
print k_cool, k_cool.articles
print k_unfinished, k_unfinished.articles