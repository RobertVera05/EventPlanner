import urllib2, urllib, json
#baseurl = "https://query.yahooapis.com/v1/public/yql?"
baseurl = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"
yql_query = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text='euless, tx')"
yql_url = baseurl + urllib.urlencode({'q':yql_query}) + "&format=json"
result = urllib2.urlopen(yql_url).read()
data = json.loads(result)

print (data.get('query').get('results').get('channel').get('item').get('condition'))

#print data['query']['results']