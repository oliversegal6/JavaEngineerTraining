### Build Project
mvn clean install

POST: http://localhost:8080/user-service-1.0-SNAPSHOT/user/users
          {"username":"admin","password":"123","firstName":"fn","lastName":"ln"}
GET: http://localhost:8080/user-service-1.0-SNAPSHOT/user/users

**Request Header**
Content-Type：application/json


## Project Structure
- Rate Plan use drools(rule engine)
- configservice（platform） to store configuration
- persistance (platform) to persist data to DB
- userserver (platform) to auth login
- employee is sample service

Interface 单独打包可以提前发布接口版本，从而隔离前后端开发，使得前后端开发可以同步进行。
Framework和具体应用之间加一层，这样可以隔离Framework 版本变化。