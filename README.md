# Team 1 ReadMe File

## Summary

Link: [Github][toGithub]
[toGithub]: https://github.com/kanei0415/VaccineCMSJavaSwing

### Description
* Login Form : 정부 사람이 맞는지 확인 (보안)
* Country : 정부의 자국 코로나 백신현황 보기 및 백신 접종, 구매 현황 표시, 자국 회사들 정보 보기 가능
  * 회사 전체 보기 및 관리 누르면 Company Frame 띄우기
* Company : 회사가 백신을 생산 및 모든 회사 정보 관리, 각각의 회사 정보도 관리
* Vaccine : 이름, 부작용 등의 정보 및 VaccineProduct[] 을 이용한 백신의 data를 저장 및 관리

### Structure
* Login
* Country(Company Show, Vaccine) -> Company(name, Vaccine)

## 2020110761 김영호
> GUI
* landing
  * CompanyLogin.java
  * CountryLogin.java
  * LandingPage.java
  * LoginHome.java
  * SignIn.java

* vaccineView
  * EffectivenessContents.java
  * InformationContents.java
  * InventoryContents.java
  * MainContents.java
  * TopBar.java
  * VaccineMainMenu.java



> MODEL
[!Alt vaccineModel](./vaccineModelStructure.jpg)
* 
  * AZ.java
  * ChadOx1.java
  * Date.java
  * AZ.java
  * AZ.java
  * AZ.java
  * AZ.java
  * AZ.java
  * AZ.java
  * AZ.java
  * AZ.java
  * AZ.java
  * AZ.java
  * AZ.java
  * AZ.java