# ExpireNoMore
![Logo of the mod](https://cdn.modrinth.com/data/cached_images/a916ba8886765e8c3548e3f6946095210d7859b1.png)

A Minecraft mod that increases the expiration time in a Minecraft server's usercache.json file.

More specifically, this mod makes it so that, every time the server is started or someone joins the server, the `usercache.json` file of the server is updated, so that whichever user's `expireson` date is less than 50 years away, will have their value increase by another 100 years.

Don't use the mod if you need the name to expire for whatever reason.

### Warning: Make a backup of your usercache.json before running this mod
#### Note: This mod cannot recover previously removed/expired usercache. It can only save what currently exists.
<br>

## Reason for this mod: 
I wanted to see and compare the player statistics of the players on my server, and found a great project to do just that: https://github.com/pdinklag/MinecraftStats

It worked well, except for one part. It didn't show all the players stats.  

Searching around, I found that this was because the player statistics are stored with the player's uuid as the filename.  
Now, this would usually be fine, as the player's uuid can be easily converted into their username if it were an online server.   
However, my server was in "offline" mode. So therefore, the uuid's could not be reversed. 

Now usually, the names and uuids are stored in a file called `usercache.json`. Except, for some reason, every cache has an expiry time on it.  
It had so happened that a few server members had not logged in for a long while, so their names weren't cached in that file. So the stats project could not display their names.  

So to finally fix that, I decided to make this mod. I don't know if there is any reason for the expiration of names in the file. If you have a need for the expiry, do not use this mod.

## About the mod

This mod should work on all possible fabric version(from `1.14.4` to the latest snapshot), with atleast the fabric loader version being above `0.15.1`  

The minimum java requirement is `java 8`, although any higher version will work.  

When you run the mod the first time, every username's expire time will increase by 100 years (as long as its not already more than 50 years away).  
