// The Cloud Functions for Firebase SDK to create Cloud Functions and setup triggers.
const functions = require('firebase-functions');

// The Firebase Admin SDK to access the Firebase Realtime Database.
const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);


exports.sendRequestToAdmin = functions.database.ref("/firebaseId/{pushId}/token").onWrite(event => {

  var str = event.data.val();
  console.log(str);

  const payload = {
    notification: {
      title: "title",
      body: "30"
    }
  }

  return admin.messaging().sendToTopic(str, payload)
  .then(function(response){
        console.log("Notification sent ", response);
  })
  .catch(function(error){
        console.log("Error sending notification: ", error);
  });
});

exports.requestApprovedByAdmin = functions.database.ref("/RequestApproved/{pushId}").onWrite(event => {

  var str = event.data.val();
  var tokenuuid = str.split(",")[0].split(":")[1];

  var theemail_beginning = tokenuuid.split("@")[0];
  var theemail_ending1 = tokenuuid.split("@")[0].split(".");
  var theemail_ending2 = tokenuuid.split("@")[1].split(".");
  var emailjoined = theemail_beginning + theemail_ending1 + theemail_ending2;

  console.log(str);

  const payload = {
    notification: {
      title: "title",
      body: str
    }
  }

  return admin.messaging().sendToTopic(emailjoined, payload)
  .then(function(response){
        console.log("Notification sent ", response);
  })
  .catch(function(error){
        console.log("Error sending notification: ", error);
  });
});

