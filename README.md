# Backend Developer Intern - Summer 2022 Shopify Developer Challenge

## Local Deployment
Requirements:
  * Docker

Run the following command in the root directory to deploy the api and the ui.

`docker-compose up`

The api will be accessible: [localhost:8080](http://localhost:8080).

The UI will be accessible: [localhost:8087](http://localhost:8087).

## API Description
### Background
This logistics company web application, allows you to keep track of your SodaPack inventory

The api will be accessible: [localhost:8080](http://localhost:8080).

#### GET all sodaPacks
Return all sodaPacks currently in the database

**Endpoint:** `GET: /sodaPacks`  

#### GET specific sodaPack
Return specific sodaPack using its' uuid

**Endpoint:** `GET: /sodaPacks/{uuid}`  

#### POST create sodaPack
Create new sodaPack

**Sample request body:**
```json
{
  "name": "Red Flavoured Soda Pop",
  "weight": 200,
  "count": 99,
  "unitsPerPack": 24,
  "volumePerUnit": 255,
  "fragile": "true",
  "bottlingType": "GLASS"
}
```

#### PUT update sodaPack
Update specific sodaPack using its' uuid
**Endpoint:** `PUT: /sodaPacks/{uuid}` 

**Sample request body:**
```json
{
  "name": "Nuclear Green Flavoured Soda Pop",
  "weight": 99,
  "count": 10,
  "unitsPerPack": 6,
  "volumePerUnit": 1000,
  "fragile": "false",
  "bottlingType": "CAN"
}
```

#### DELETE update sodaPack
Delete specific sodaPack using its' uuid

**Endpoint:** `DELETE: /sodaPacks/{uuid}` 

#### EXPORT all sodaPacks to CSV
Exports all sodaPacks in a CSV format

**Endpoint:** `GET: /sodaPacks/download` 