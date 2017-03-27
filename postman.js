tests["Status code is 200"] = responseCode.code === 200;

tests["Response time is less than 200ms"] = responseTime < 200;

var contentTypeHeaderExists = responseHeaders.hasOwnProperty("Content-Type");
 
tests["Has Content-Type"] = contentTypeHeaderExists;
 
if (contentTypeHeaderExists) {
    tests["Content-Type is application/json"] = 
      responseHeaders["Content-Type"].has("application/hal+json");
}
