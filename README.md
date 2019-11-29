
- Navigate to Home Page

        home.NavigateHomePage();
        
- Click on the take a tour and skip it 

        home.clickUntilHome();
 
- Select the currency  
       
        regist.selectCurrency("US Dollars");
        
- Go to regist page
    
        regist.goRegist();
        
- Insert email

        regist.insertMail(random);
        
- Create the new user on regist page

        regist.fieldRegist(random);
        
- Then validating the user is created

        regist.validateRegist();