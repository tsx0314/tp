# Chuah Wan Juin's Project Portfolio Page
## Project: Food Supply Tracker

### Overview
Food Supply Tracker (FSP) is a desktop food list tracking the expiry date of the food in the list.
It is optimized for use via a Command Line Interface (CLI) .
If you can type fast, FSP can get your food management tasks done faster than traditional GUI apps.

### Contributions
Given below are my contributions to the project.
1) New Feature: List Command
  * What it does: List out all the food products in order of expiry dates. 
  * Justification: This feature improves the product significantly because
a user can view all the food products available. This make looking at all 
food products a user have much more convenient. In addition, listing food in order 
of expiry dates makes it neater for user to look at what are the foods that are expiring soon.
  * Enhancement implemented: 
    * There is an indicator of the number of days left to expired beside expiry date.
    * There is an indicator of the number of days the food has expired beside expiry date.
    * There is a label beside each food to indicate whether the food is expired or not.
    * Remind users the number of food products they still have in the list.
    
2) New Feature: Add `-u` unit feature in the Add Food feature
  * What it does: Allows the addition of unit to the food products. 
  * Justification: This feature improves the product significantly because
a user can choose unit to gauge the remaining quantity 
of the food product that they are left. For example if the remaining quantity
is 2 without unit, it would be confusing how much is a "2". It could be 2 packets
or 2 boxes.
  * Highlights: This enhancement affects existing commands and commands to be added in 
the future. It requires integration with the rest of the existing food details. For example,
it would need the value of `quantity` to determine if it is a plural form or singular form.
  * Enhancement implemented: 
    * There is a fixed set of units that users can choose from (Enumerations).
    * When user enters a common unit such as `milligrams` or `litre`, the program would automatically
    assign units `mg` and `l` to the food respectively, according to the fixed list of units provided.
    * The default unit of a food product would be set to `unit` and `units` according to the value of quantity.
    * When a user updates the quantity, the unit would change to plural or singular form according to it, if applicable.

3) New feature: Clear Command
   * What it does: Allows users to clear the entire food list using one command.
   * Justification: This feature improves the product as users can just delete the entire food list, without the need of 
   deleting food products one by one. Practically, this feature is important as the user could have many expired foods 
   and want to delete the entire food list in one shot.

4) New feature: Exit Command
  * What it does: Allow users to exit the application,
  * Justification: This feature is a core feature of the product as users can shut down the application
when he or she is done using it.

5) Enhancement: Remove feature that do not take in non-integers 
  * Checking if an input is an integer or not, if it is not then an error message will be showed up to the user.
  * Improve the clarity of the error message being shown to the users.

6) Enhancement: Command Result 
  * What it does: Printing of response to users after each command entered by users.
  * Justification: This feature is a core feature of the product as it makes it clearer for the users that the program 
has already executed what the user asks it to do. It also tells the users what they have entered wrongly in some cases 
(in addition to exceptions). This feature is important to show that it is responsive to the users' command.  
  * Highlights: All commands will have to depend on this enhancement feature to print their respective results to users.
  * Credits: https://github.com/se-edu/addressbook-level2/blob/master/src/seedu/addressbook/commands/CommandResult.java

### Code contributed
[RepoSense link](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17&tabOpen=true&tabType=authorship&tabAuthor=wanjuin&tabRepo=AY2223S2-CS2113-W13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=functional-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Project management
* Set issues on milestone `v1.0` - `v2.1` on GitHub after finding bugs or possible enhancements.
  * [Link to Issues added by me](https://github.com/AY2223S2-CS2113-W13-3/tp/issues?q=is%3Aissue+is%3Aclosed+author%3Awanjuin)
* Review issues set by group members and other peers (PE-D).
* Assign issues to myself and group members.
  * [Link to Issues assigned to me](https://github.com/AY2223S2-CS2113-W13-3/tp/issues?q=assignee%3A%40me+is%3Aclosed)
* Request for group members' review for my merge request on GitHub.
  * [Link to my Pull Request](https://github.com/AY2223S2-CS2113-W13-3/tp/pulls?q=is%3Apr+is%3Aclosed+author%3Awanjuin)
* Review group members' merge request.
* Commented and suggested changes on group members' merge request.
* Requested changes on group members' merge request when it would affect the overall functionality of the app.
  * [Link to Merge Request reviewed by me](https://github.com/AY2223S2-CS2113-W13-3/tp/issues?q=reviewed-by%3Awanjuin)

### Documentation
* User Guide: 
  * List Command section
  * Clear Command section
  * Exit Command section
  * Add Unit in Add Command section
  * Find Command example of usage
  * Update Command example of usage

* Developer Guide:
  * Diagrams:
        + ListCommandSequenceDiagram.puml
        + ListCommandClassDiagram.puml
  * Specifications:
        + ListCommand implementation description
  * User Stories
  * Non-functional Requirements

* Logging of the project
  * [Link to Pull Request for Logging](https://github.com/AY2223S2-CS2113-W13-3/tp/pull/58)

### Community
* PRs reviewed (with non-trivial review comments):  [Link to Merge Request reviewed by me](https://github.com/AY2223S2-CS2113-W13-3/tp/issues?q=reviewed-by%3Awanjuin)
* Reported bugs and suggestions: [Link to Reported Bugs](https://github.com/AY2223S2-CS2113-W13-3/tp/issues?q=author%3Awanjuin+label%3Atype.Bug+)