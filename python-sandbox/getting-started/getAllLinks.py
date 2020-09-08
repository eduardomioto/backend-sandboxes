import urllib.request as urllib2
import re

#connect to a URL
url = "http://www.mioto.com.br";
website = urllib2.urlopen(url)

#read html code
html = website.read()

#use re.findall to get all the links
links = re.findall('"((http|ftp)s?://.*?)"', html)
