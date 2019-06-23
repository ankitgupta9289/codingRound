# TestVagrant hiring challenge

**Code review comments**
---------------------------------
1. No proper naming convention followed.
2. No design pattern and framework (for ex. Page Object Pattern) followed.
3. Element identifiers were directly used in line hence no re-usability.
4. Chrome drivers for all OS were added in the code repository they get updated on frequent basis.
5. Hard waits were used Thread.sleep at many places.
6. Xpath writing strategies are not good they are very prone to break easily.
7. Webdriver is created and destroyed after every test it increases execution time so reuse same driver again.
8. isElementPresent method does not confirm the visibility of element.
9. Test data is directly used anywhere in the tests whereas there should be some common csv or properties file to store the same. 
10. No use of implicit wait while initializing driver. 

**Code Enhancements**
----------------------------------
1. Proper naming conventions are followed and fixes are done to make tests pass.
2. Page object pattern is used to achieve better re-usability, maintainability and readability.
3. Some classes are also using page factory pattern just to demonstrate the use.
4. Singleton design pattern is used for page object classes.
5. Extent reports are used to generate fancy html reports.
6. Auto screenshot capture functionality implemented on test failure.
7. Maven TestNG Surefire plugin is used to execute through commandline.
8. Inheritance and Abstraction is used where ever required.
9. Hard waits are completely avoided by using explicit wait.
10. Bonigarcia webdrivermanager library is used so as to remove hassle of downloading chromedriver and geckodriver and set system path.
11. Support is given to run of firefox driver as well.

**NOTE :-**
----------------------------------
1. Parallel execution is not implement as we had only 3 cases however that can easily be done by using threadlocal driver and IInvokedMethodListener.
2. Retry mechanism for failed cases not implemented that can be easily done using IRetryAnalyser.