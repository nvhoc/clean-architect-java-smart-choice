# SMART CHOICE PROJECT

### Objective:
Build MVP Version for "smart choice" project that user can search a product then compore price, promotion in almost ecommerce websites

### Background/Assumptions:
1. To get Information a product we should call to 3rd party serivce
2. We need optimize the cost when traffic increase
3. Tracking user activity for audit
4. As a service, it needs be dockerized, monitored, healthcheck, livecheck
5. Business will be changed so fast, we need increase our team size

### High Level design:

1. Code Architecture: Clean Architecture (Unclebob). why? to build an MVP project, our business and technical decision are very early stage that we will change a lot in future. For instance, in our project we don't know how many ecommerce sites, we should change to a solution that help optimize cost, we need increase our team size.

Here is my code structure:
+ core: Product entity and ProductSearchUC.getProductListByESiteProvider -> this is our business requirement
+ provider: thirdparty.product + thirdparty.esite  -> we change them later
+ entrypoint: rest.product (/product/search/:name) + actuator (spring-boot-starter-actuator)
+ configuration: wires everything together, application here


2. What we do for traffic increase and optimize cost:

+ Caching: we cache every request go to thirdparty.esite -> it is very simple that to TikiESiteWithCache implement ESiteFunctinonl then do get in caching or build caching by TikiESite.searchProduct

+ Build crawler and work in our ElasticSearch DB: 
  - create a new entrypoint is job that do crawler all ecommerce websites then push to our ElasticSearch DB
  - add elastic.product -> query to elastic search DB and return product list

### Building and Running the application:

1. Local, ID: open and run the main class "dev.hocnguyen.smartchoice.configuration.Application"

2. Docker: 
```
docker build -t smartchoice .

docker run --name=smartchoice -d -p 8080:8080 smartchoice
```

3. Gitlab-CI: please check https://github.com/nvhoc/gitlab-jobs for adding env: autotag every latest commit, docker push to registry, deloy to ec2


### API request:

1. Search a product
```
curl --location --request GET 'localhost:8080/product/search/television'
```

2. Monitoring

```
curl --location --request GET 'http://localhost:8080/actuator'
```

### Microservices Design:

![microservices-design](https://storage.googleapis.com/hocnguyen_dev/Smart%20Choice%20(1).jpg)

There are more things in a real production app:
1. Web + App tracking user's behaviour (Google Tag Manager, Google Analytics, our Big Query for analytics ...)
2. Web servers (SSR) + Static CDN (CloudFront, Fastly, CloudCDN ...) to fastest return UI to users
3. Horizontal Scale + HA: There are service load balancers to our services what deploy in n containers (base on Docker)
4. Logging Central: to Audit/Debug issues of our services, We choice Kafka to be at the middle then stream all our logs to an Elasticsearch cluster that having some dashboard (Kibana) for dev/business people can easily to check
5. System monitor dashboard: There are a lot of use case for that such as tracking CPU, RAM, error request, success rate, trigger alert to team who manage a service


### Alternatives

1. Clean Architecture: we can generate a service by JHipster, its structure is more simple and focus on technical
2. More simple microservice architecture: remove 3,4,5 in microservices design above by using AWS Lambda, AWS Cloud Watch, AWS SNS 

### Risk/Drawbacks 

1. Clean Architecture:
+ Indirect – there will be a lot more interfaces than one might expect 
+ Heavy – in the sense that you might end up with a lot more classes than you currently have in your projects

2. Microservice: 
+ Too complex for a MVP, we should deliver as fast as possible way to reach market. so, in MVP, it's better to 1-2 dev guys for building whole product




