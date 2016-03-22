# LoggerBot
A bot that logs messages. Nice for keeping them trollers at bay.

LoggerBot Exists solely for logging messages send in the Discord Channels the bot is connected to.

Keep in mind, this is a W.I.P. bot.

##Setup

1. Download the .jar and put in in the designated folder.
2. Open up the command line inside the folder and use: java -jar LoggerBot.jar
3. Fill in login credentials and the bot will display it is ready.

##Info

The bot will create 2 folders and 1 config file. In the config file you will find several options that you can turn ```true``` or ```false```

| Config        | Description   | Default  |
| ------------- |-------------  | -----    |
| logMessages   | Logs every basic message send in all the chat channels the bot is connected to. | false |
| logDeletes    | Logs every message that is deleted in all the chat channels the bot is connected to.       |  true |
| logEdits | Logs every message that is edited in all the chat channels the bot is connected to. Shows old and new message|true |
| addRoleToLog    | Logs the role of the person beneath the initial log       |  false |

In the logs folder there will be more folders with the logs of the channels they come from. This should be pretty self explanatory.

##Download
[This](http://ouo.io/rfel8L) is the link to the download of the bot(.jar file).
Or if you want a direct download instead of 5 extra seconds of waiting which benefits me in many ways, click [this](http://www.mediafire.com/download/e4w5p4w24874xj5/LoggerBot.jar).

##Contributing
If you have any suggestions, or want to help improve my code or this project. Feel free to make an issue or upload to the dev branch!
