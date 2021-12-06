# DemoAutomation_WinAppDriver
 Create a test example for Registration/Login WPF with WinAppDriver + Java


Pre-Condition:
- Download WindAppDrive: https://github.com/Microsoft/WinAppDriver/releases
- Follow "Install & Run WinAppDriver" section in this URL to install "WindowsApplicationDriver-1.2.99-win-x64.exe" : https://github.com/microsoft/WinAppDriver
- After installed, go to folder "C:\Program Files (x86)\Windows Application Driver" and open "WinAppDriver.exe" by administrator permission to start server and keep it always open during the automation execution time.

Test Cases which designed:
- TC01: Check message when submiting form with invalid required value
- TC02: Register a account successful with valid information
- TC03: Login application with unregistered account
- TC04: Login account successful with valid information


Results:
- Passed: TC01 & TC02
- Not done yet: TC03 & TC04


Reasons & Issues:
- For now, I got a stuck issue when swiching window from "Registration" to "Login" screen. Drive is lost after doing the switch action. So, TC03 and TC04 are not done yet.
- Not designed report template yet.
