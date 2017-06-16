# responsecompare
Http API Request Response Test Harness

Makes API requests and compares the json or xml responses to expected results.

Requests go in a .req file stored under the data/consult directory.

Here's an example request in the .req file.

TESTCASE name, description

  GET /url?param=value

  POST /url

  BODY {"json": "body"}
  
Any response in json can be used inside ${} for the next request inside a testcase. For example:
If the json response contains {"one": "more"}

the next request in the testcase could contain...

GET /url?one=${one}

when making the request ${one} would be replaced by the string:  more
