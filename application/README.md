# lonefootballer
App to help young footballers with trials, training and other football related tasks and activities.

## Concepts
**Clubs:** Represent Football Clubs. They will be uniquily identified by Club User Name. They can have many players and many ClubPeople.

**ClubPeople:** Club officials, like presidents, directors, coaches. secreataries. They are part of one or more Clubs.

**Players:** People who play football. They might or might not be associated with a club. They can only be associated with one club at a time.

**Events:** Club events, for instance Football clinics. A Club can have many events, an event belongs to a club.

**Trials**: Clubs have trials in order to attract new talent. Clubs crteate trials and players submit their interest for their trials. A trial belongs to a single club. Clubs accept or reject player's EOI for their trials.

**EOI**: Players submit Expressions of Interest to club's trials. One player can submit many EOI to different clubs.

**Offers**: Clubs make offers to players. A club can make offers to many players and a player can receive offers from many clubs.

**Media:** Players media. Players can upload link to YouTube videos showcasing thier skills. 


## Access Patterns



## Developer Info
### AWS Helpful commands

#### The following command displays your default account information, including the account number: 
- aws sts get-caller-identity
- aws sts get-caller-identity --profile prod

#### To display the default Region, use aws configure get.
- aws configure get region
- aws configure get region --profile prod

#### Lambda
### CDK

#### Creates a ZIP file with the application. 
mvn clean package

