Feature: Login and Logout on two devices

Scenario: Alternate login and Sequential logout

	Given both the devices are initialized

	When Device A launches google app
	And Device B launches google app

	And Device A taps on add account
	And Device B taps on add account

	And Device A enters email "deviceA@gmail.com"
	And Device B enters email "deviceB@gmail.com"

	And Device A enters password "passwordA"
	And Device B enters password "pasSwordB"

	Then both devices should be logged in

	When Device A logs out
	And Device B logs out

	Then both devices should be logged out
