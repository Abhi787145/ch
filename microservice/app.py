from flask import Flask
import redis


app=Flask(__name__)

cache=redis.Redis(host='redis', port='6379')


def hits():
	return cache.incr('hit')


@app.route('/')
def hello():
	count=hits()
	return '<h1>you have visited this page {} times</h1>'.format(count)



