# calendar

Simple CLI app that scrapes Univr/orari website to obtain and print the current Computer Science course class schedule.

<b> Note: currently it doesn't work as the search parameters are hardcoded into the program and have to be changed in order to correctly get and print the current schedule</b>
### Installation
//TODO

### Usage
To get the current week schedule just run
```
cal 
``` 
This is the same as 
```
cal -week=current
```
To print a different week, just specify the date range (Monday-Sunday, format DD/MM-DD/MM), like so
```
cal -week=19/11-26/11
```

or just 
```
cal -week=19/11
```
