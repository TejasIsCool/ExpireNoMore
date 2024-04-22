# ExpireNoMore
A Minecraft mod that increases the expiration time in a Minecraft server's usercache.json file.

More specifically, this mod makes it so that, every time the server is started, or someone joins, the `usercache.json` file of the server is updated, so that the `expireson` date is increaded by a hundred years.

This mod is mainly meant to be run once to forever keep the usercache saved.

### Warning: Make a backup of your usercache.json before running this mod
#### Note: This mod cannot recover previously removed/expired usercache. It can only save what currently exists.
<br>

## Reason for this mod: 
I wanted to see and compare the player statistics of the players in my server, and found a great project to do just that: https://github.com/pdinklag/MinecraftStats

It worked well, except for one part. It didn't show all the players stats.  

Searching around, i found that this was because the player statistics are stored with the player's uuid as the filename.  
Now, this would usually be fine, as the player uuid can be easily converted into their username if it were an online server.   
However, my server was "offline" mode.  So therefore, the uuid's could not be reversed. 

Now usually, the names and uuid's are stored in a file called `usercache.json`. Except, for some reason, every cache has an expiry time on it.  
It had so happened, that a few server members had not logged in for a long while, so their names weren't cached in that file. So the stats project could not display their names.  

So to finally fix that, i decided to make this mod. I don't know if there is any reason for the expiry of names in the file. If you have a need for the expiry, do not use this mod.

## About the mod

This mod should work on all possible fabric version(from 1.14.4 to the latest snapshot), with atleast the loader version being above `0.15.1`  

The minimum java requirement is `java 8`, although any higher version will work.  

It is recommended to use this mod once (Put it in the server's mods folder, run the server once, and take it out). If you do that, every username's expire time will increase by 100 years.  
Nothing bad will happen if you keep using this mod, although it wont be much useful then (I dont expect your server to last over a hundred years)
