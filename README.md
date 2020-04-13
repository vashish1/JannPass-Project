# JannPass- A movement manager during this pandemic.

## Problem
    India is under lockdown situation feom past 20 days. And if we have to fight this pandemic successfylly this must be extended.           Confirmed cases have tolled over 8000!
    Under these circumstances the only solution is to stay home and not go out. The problem is people are not understanding the deapth       of the issue and roaming around casually. Also people do need their daily rashans. 
    There need to be a system that allows limited number of people during lockdown to move out of their home.

## Our Solution-

    •	Our Solution is both web and app based.
    •	We publish e pass for common people to get their rashan and required commodities.
    •	E-pass will be issued in three time slots for each day during lockdown.
    •	For each time slot limited passes, eg:100, will be available.
    •	Once pass is issued, same person cannot issue another for 1week.
    •	One person allowed per pass and pass is issued with Aadhaar number.
    •	 Police will have alternate login path.
    •	They will have scanner built in their page which will verify the pass.

## Major features of this Application:
        1. Only 50 Epass issued every week.
        2. Aadhar card validation.
        3. Qr in the form of Epass.
        4. Easy Police login.
        5. Inbuild Qr scanner for Police.
        6. Mass gathering Reporting.
        7. Report to any problem faced by common people.
        8. COVID-19  real time stats.
        
 ### This application is built for both web and app.
 ### The android application is completely working and is build on firebase.
 ### But due to shortage of time the integration of frontend and backend is not completed else the web app's prototype is completely          ready, the API's are also ready.
 
 ## Web application-
        Frontend: The frontend is designed using react and bootstrap.
        Backend: The backend is vompleted using Golang and mongoDB as database.
        
 ## Android application-
        The application is built on firebase for now,as backend support.
        Web scrapping is used to fetch the data of COVID 19.
        
##  To test the backend:
    
    # Download Golang into your system from the given link:
       
       https://golang.org/dl/
    
    # Setup Go    
    
       https://golang.org/doc/install
       
    # Clone this repo into your system.
    
    # move the "Jann-Pass" folder into your GOPATH
    
    # use "go get ..." to download the open source packages.
    
    # Use any editor to open the Jann-Pass folder
    
    # Using cmd run the following commands:
    
       $go build
       $./Jann-Pass
       
     # use Postman to check the API working.  
