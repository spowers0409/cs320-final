# cs320-final
Project putting all the tasks and scheduling together with all JUnit tests. 

<h1>Alignment to Requirements</h1>
<p>My testing approach was to test exactly what the requirements for each item. were. When testing task.java, I created tests to test for length of each variable; ID, name, and description. Tests were also created to test for null for each variable. I wanted to make sure that for each requirement listed, there a test in line for it</p>
<br>

<img src="https://user-images.githubusercontent.com/85845285/177078867-08dedae0-37a9-483a-ba05-27c7894e13e1.png" width=600>

<br>
<br>
<h1>Effective Tests</h1>
<p>I knew my tests were effective when I was finally able to run the test and it give me zero errors or failures. This took a lot of back-and-forth testing and changing of my code to make sure that it worked appropriately. The best part about JUnit tests and doing this inside the Eclipse IDE is that after the test fails, it shows you where the test failed at, and I am allowed to change up my code as many times as I needed in order to make it not fail. By the end of project one, I was able to run all my tests with zero failures. </p>
<br>
<br>
<h1>Technically Sound Code</h1>
<p>In order to verify that my tests were technically sound, I also tested to make sure that there would be failures. Each variable in my project had specific lengths and needed to not be null. In order to test for this, I needed to create variables that were too long and were null so that the test could fail, and it would let me know that the test is indeed doing its job appropriately. By doing this, not only do I know that my project will work when the correct information is entered, but I also know that errors will be thrown, and the user will be prompted to input correct information.</p>

<br>

<img src="https://user-images.githubusercontent.com/85845285/177078868-9022cc1a-ebe4-460d-b70e-c2e71d0ddc5c.png" width=600>
<img src="https://user-images.githubusercontent.com/85845285/177079542-aacecbe8-31e5-4972-ba03-9f10e2461da1.png" width=600>

<br>
<br>
<h1>Efficient Code</h1>
<p>To be efficient in my code, I made sure to follow everything in order. When I created the variables for taskID, taskName, and taskDescription, I followed the same order in my test classes to make sure that anyone who reads my code would be able to follow along without having to jump back and forth to find where they are. This code is easily readable with the comments that were placed in the code to let the user know what each portion of the code is supposed to be doing. Not only was I just testing names, but first name and last name length as well to ensure validity to an extreme.</p>
<br>

<p float="left">
<img src="https://user-images.githubusercontent.com/85845285/177079735-a9dc7e0f-1766-4ca4-88ce-e2803b73f955.png" width=300>
<img src="https://user-images.githubusercontent.com/85845285/177079737-8027f41b-a118-458c-9ec7-ad1d1af589b0.png" width=300>
</p>
<br>
<br>
<h1>Techniques Employed</h1>
<p>Unit testing is the type of testing that we are doing here, and unit testing is the test that tests individual blocks of code. That is, for each function or routine or procedures I had put in place, each of these sections will be tested individually. This type of testing is great for developers to make sure that the small pieces of code that are being created are also being tested for validity before going on to the next phase of development. It really saves on time and finances to test code while you are coding. Not only are these types of tests easy to design, but they are also easy to manipulate.</p>
<p>While unit testing, I did test for every test created, rather than creating all the tests and testing it all at once. I did so that especially for AppointmentTest.java as I have six different tests in this, and I did not want to come up with multiple errors and have to try and track down all the causes for all the errors. By testing one at a time while still writing the code, I was able to narrow down and issues much quicker. </p>
