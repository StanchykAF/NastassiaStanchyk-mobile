# For running tests locally use testNG.xml file

1. **_nativeTNG.xml_** for running tests for native app (put your .apk to src/main/resources folder)
2. **_webTNG.xml_** for running tests for web app

Change parameter 'deviceName' in _testNG.xml_ file if you want to run tests on real device

If you use appium version 1, change <ts.appium> property in pom.xml to http://localhost:4723/wd/hub and remove parameter 'automationName' from _testNG.xml_ files and _BaseTest_ class.

## How to run tests remotly on saucelabs.com

1. Create account on saucelabs.com
2. Set your username and access key in _Run configuration_ -> _VM option_ -> -Dusername=your_username -DaccessKey=your_access_key
3. For running tests remotly use _remote*TNG.xml_ files
