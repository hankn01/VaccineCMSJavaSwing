- Team 1 ReadMe File -
Summary
[toGithub] https://github.com/kanei0415/VaccineCMSJavaSwing

- Description -
1. Login Form : 정부 사람이 맞는지 확인 (보안)
2. Country : 정부의 자국 코로나 백신현황 보기 및 백신 접종, 구매 현황 표시, 자국 회사들 정보 보기 가능, 회사 전체 보기 및 관리 누르면 Company Frame 띄우기, 백신 상세보기 가능
3. Company : 회사가 백신을 생산 및 모든 회사 정보 관리, 각각의 회사 정보도 관리, 백신 상세보기 가능
4. Vaccine : 이름, 부작용 등의 정보 및 VaccineProduct[] 이용한 백신의 data를 저장 및 관리
<Structure>
Login -> Country(Company Show, Vaccine) -> Company(name, Vaccine)

- 조원별 구현 부분-
1. 2020110761 김영호
A. GUI

landing Package - File I/O, GUI, StringTokenizer
a. LandingPage.java
This page is the first landing page that users see when they execute codes.
b. LoginHome.java
This page is for logging in.
c. SignIn.java
This page is for membership and runs file output with Account.txt.

vaccineView Package - GUI, ArrayList
a. EffectivenessContents.java
This page compares the efficacy and risk of vaccines.
b. InformationContents.java
This page shows information about the vaccine.
c. InventoryContents.java
This page shows the stock of the vaccine.
d. MainContents.java
This page is the home screen.
e. TopBar.java
This component is the top bar of all screens.
f. VaccineAdd.java
This frame is for add VaccineProduct to Inventory.
g. VaccineMainMenu.java
This frame is for landing Vaccine GUI.

B. MODEL
3. vaccine - Class, Inheritance, Interface : Abstract Class for one type of vaccine
a. RNAVaccine : Abstract Class for RNA type of vaccine
b. Moderna : Simentic Class for Moderna
c. Pfizer : Simentic Class for Pfizer
d. VirusVectorVaccine : Abstract Class for Virus Vector type of vaccine
e. AZ : Simentic Class for AZ
f. Yansen : Simentic Class for Yansen
g. DNAVaccine : Abstract Class for DNA type of vaccine
h. ChadOx1 : Simentic Class for ChadOx1
i. VaccineProduct : Data Class for Vaccine Product
j. Date : Data Class for Product date and Expire date of VaccineProduct
k. VaccineType : There is an enumeration of the types of vaccines.
l. SideEffect : There is an enumeration of the side effects of vaccines.
m. VaccineAddable : Interface for writing files for adding vaccine products to countries and companies

2.2020115974 한강민

A. GUI & MODEL

country Package - GUI, Class for store national vaccine information
a. CountryScreen.java
This page is the main page of this program. Users are able to select the function that they need.
b. GUISelectCompany.java
This is the select screen for the vaccine owned by country. They can select the vaccine manufacturer.
c. LocalStockScreen.java
This is the stock screen for local government.
d. LocalVaccineControl.java
This is the allocate screen for local government using ArrayList
e. NationalStockScreen.java
This is the menu screen. You can select company stock menu or vaccine get menu.
f. NationalVaccineControl.java
This is the screen for vaccine introduce.
g. VaccineSTCClass.java
Store the Information about Vaccine Amount in specific location. (Serializable)
h. VaccineForIO.java
Set the company of vaccine (opening the file) and fill the inventory, and be able to write the file about the vaccine.
i. Country.java
Stub class
j. VaccineLocation.java
Stub class