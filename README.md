# Team 1 ReadMe File

## Summary
[toGithub] https://github.com/kanei0415/VaccineCMSJavaSwing

### Description
* Login Form : 정부 사람이 맞는지 확인 (보안)
* Country : 정부의 자국 코로나 백신현황 보기 및 백신 접종, 구매 현황 표시, 자국 회사들 정보 보기 가능, 회사 전체 보기 및 관리 누르면 Company Frame 띄우기, 백신 상세보기 가능
* Company : 회사가 백신을 생산 및 모든 회사 정보 관리, 각각의 회사 정보도 관리, 백신 상세보기 가능
* Vaccine : 이름, 부작용 등의 정보 및 VaccineProduct[] 이용한 백신의 data를 저장 및 관리

### Structure
* Login
* Country(Company Show, Vaccine) -> Company(name, Vaccine)

## 2020110761 김영호
> GUI   
* landing - File I/O, GUI, StringTokenizer
  * LandingPage.java
    * This page is the first landing page that users see when they execute codes.
  * LoginHome.java
    * This page is for logging in.
  * SignIn.java
    * This page is for membership and runs file output with Account.txt.

* vaccineView - GUI, ArrayList
  * EffectivenessContents.java
    * This page compares the efficacy and risk of vaccines.
  * InformationContents.java
    * This page shows information about the vaccine.
  * InventoryContents.java
    * This page shows the stock of the vaccine.
  * MainContents.java
    * This page is the home screen.
  * TopBar.java
    * This component is the top bar of all screens.
  * VaccineAdd.java
    * This frame is for add VaccineProduct to Inventory.
  * VaccineMainMenu.java
    * This frame is for landing Vaccine GUI.
![Alt vaccineModel](./vaccineModelStructure.jpg)
> MODEL
* vaccine - Class, Inheritance, Interface : Abstract Class for one type of vaccine
  * RNAVaccine : Abstract Class for RNA type of vaccine
     * Moderna : Simentic Class for Moderna
     * Pfizer : Simentic Class for Pfizer
  * VirusVectorVaccine : Abstract Class for Virus Vector type of vaccine
     * AZ : Simentic Class for AZ
     * Yansen : Simentic Class for Yansen
  * DNAVaccine : Abstract Class for DNA type of vaccine
     * ChadOx1 : Simentic Class for ChadOx1
  * VaccineProduct : Data Class for Vaccine Product
     * Date : Data Class for Product date and Expire date of VaccineProduct
* VaccineType : There is an enumeration of the types of vaccines.
* SideEffect : There is an enumeration of the side effects of vaccines.
* VaccineAddable : Interface for writing files for adding vaccine products to countries and companies
 
## 2020115974 한강민
> GUI
* country - GUI, Class for store national vaccine information
  * CountryScreen.java
    * This page is the main page of this program. Users are able to select the function that they need.
  * GUISelectCompany.java
    * This is the select screen for the vaccine owned by country. They can select the vaccine manufacturer.
  * LocalStockScreen.java
    * This is the stock screen for local government.
  * LocalVaccineControl.java
    * This is the allocate screen for local government using ArrayList
  * NationalStockScreen.java
    * This is the menu screen. You can select company stock menu or vaccine get menu.
  * NationalVaccineControl.java
    * This is the screen for vaccine introduce.
  * VaccineSTCClass.java
    * Store the Information about Vaccine Amount in specific location. (Serializable)
  * VaccineForIO.java
    * Set the company of vaccine (opening the file) and fill the inventory, and be able to write the file about the vaccine.
  * Country.java
    * Stub class
  * VaccineLocation.java
    * Stub class
