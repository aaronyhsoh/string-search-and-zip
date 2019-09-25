# Project Ubin Mock API
This document comprises of the APIs that are required for the UI.

## List of endpoints
* [Issue an asset on the STACS network](#issue)
* [Retrieve information about an asset](#retrieve)
* [Subscribe to an asset](#subscribe)
* [Verify account](#inspect)
* [Dispute a transaction](#dispute)

### <a name="issue"> Issue an asset on the STACS network
This is a POST request to the STACS network to issue an asset. <br>
**/v1/issueAsset**

**_Request body:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| securityName  | String | Name of asset to be issued |
| securityClass | String | Class of asset to be issued |
| tickerCode    | String | Abbreviation of asset  |
| uniqueId      | String | Unique identification code of asset |
| issuer | String | The entity issuing the asset |
| approvalAuthority	| String | The authority that approves the issuance of the asset |
| issuanceParams |	Object	| Contains the following asset information:	 <ul><li> Issuing address</li><li>Total and reserved amount</li><li>Lot size</li><li>Price per unit</li><li>Start and end date of asset</li><li>Frequency</li></ul>|
| issuanceConds |	Object	| Contains the following conditions of the asset:	 <ul><li> Exchange it is listed on</li><li>Lead underwriter</li><li>Permitted nationalities and residences</li><li>Investor type</li><li>KYC provider</li><li>Min and max purchase lot</li><li>Lock up days</li><li>Disbursement currency</li><li>Annualised interest rate</li></ul>|
| extendedInfo	| Object	| For future upgrade options |

**_Response body:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| responseCode  | String | Response code that shows the status of the request |
| msg | String | Details of the response code |
| data  | Object | Contains the following details of the new asset: <ul><li>Issuance status</li><li>Ticker code, asset name and unique ID</li><li>transaction ID</li></ul> |

### <a name="retrieve">  Retrieve information about an asset
This is a GET request to the STACS network to retrieve information about an asset for display on UI. <br>
**/v1/viewAsset{tickerCode}**

**_Request parameters:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| tickerCode  | String | Abbreviation of asset |

**_Response body:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| responseCode  | String | Response code that shows the status of the request |
| msg | String | Details of the response code |
| data | Object | Contains the following information of the asset: <ul><li>Ticker code, asset name and unique ID</li><li>Available units </li><li>Issue and expiry dates</li><li>Minimum and maximum purchase price</li><li>Price per unit and payment currency</li><li>Coupon frequency</li></ul> |

### <a name="subscribe">  Subscribe to an asset
This is a POST request to the STACS network to subscribe to the asset. <br>
**/v1/subscribeAsset**

**_Request body:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| accountInfo | Object | Contains the following information about the entity subscribing to asset:<ul><li>Account Type (STACS or Ubin)</li><li>STACS wallet address</li></ul>|
| tickerCode | String | Abbreviation of asset |
| amount | Long | Amount of asset to subscribe |
| extendedInfo | Object | For future upgrade options |

**_Response body:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| responseCode  | String | Response code that shows the status of the request |
| msg | String | Details of the response code |
| data | Object | Contains the following information of the asset: <ul><li>Transaction ID</li><li>Ticker code, asset name and unique ID</li><li>Subscribed amount</li><li>Date of subscription</li><li>Validity</li><li>Price and currency</li></ul> |

### <a name="inspect">  Verify account
This is a POST request to either STACS or Ubin network to fetch the account details in order to verify that transaction has gone through. <br>
**/v1/verifyAccount**

**_Request body:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| walletAddress | String | Address of the wallet |
| amount | Long | Amount of asset to verify
| tickerCode | String | Abbreviation of asset |
| accountType | String | Type of account (Ubin or STACS) |
| extendedInfo | Object | For future upgrade options |

**_Response body:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| responseCode  | String | Response code that shows the status of the request |
| msg | String | Details of the response code |
| data | Object | Contains the following information of the account: <ul><li>Token code, unique ID and name<li>Amount of token</li><li>Status of transaction</li><li>Date of transaction</li></ul> |

### <a name="dispute">  Dispute a transaction
This is a POST request to Ubin network to dispute a transaction. <br>
**/v1/disputeTransaction**

**_Request body:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| transactionID | String | The ID of the transaction to be disputed |
| accountInfo | Object | Contains the following information about the entity subscribing to asset:<ul><li>Wallet address</li><li>Account type</li></ul> |
| tickerCode | String | Abbreviation of asset |
| amount | Long | Amount to be disputed |
| extendedInfo | Object | For future upgrade options |

**_Response body:_**

| Attribute     | Type          | Description                     |
| ------------- |:-------------:| :-------------------------------|
| responseCode  | String | Response code that shows the status of the request |
| msg | String | Details of the response code |
| data | Object | Contains the following information about the dispute submission: <ul><li>Date and time of dispute</li><li>Amount disputed</li><li>Status of dispute</li></ul> |




