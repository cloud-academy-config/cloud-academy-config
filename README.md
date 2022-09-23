# Java 샘플 소스(with Config management) 및 CI/CD 파이프라인 템플릿 

#
## 1. 목적
- 빠른 개발 및 빌드/배포에 필요한 기본 환경을 제공
  <br/><br/>

## 2. 제공된 템플릿 정보
### 2.1. 샘플 소스 코드 Repository
- Software 설계/개발 완성도를 높이기 위한 레이어드 아키텍처 구조의 Java 소스
- 레이어드 아키텍처 계층 및 Gradle 빌드 툴의 멀티 프로젝트 기능이 적용되어 있는 템플릿
- Config management 시스템이 적용되어 있는 소스 코드 템플릿 
  <br/>

> 기본적진 개발 틀을 제공하기 위한 샘플이며, Java 버전, 빌드 버전 등 요구사항에 맞게 수정 후 개발 필요

<br/>

### 2.2. Configuration Repository
- <소스코드>-cfgstore 이름의 Repository
- K8S 배포를 위한 샘플 Manifests (yaml) 파일 또는 EC2 배포를 위한 샘플 CodeDeploy 파일
- CTO의 표준 브랜치 및 배포 전략에 준하는 빌드/배포 GitHub Actions Workflow (파이프라인)
  <br/>

> 샘플 앱에 준하는 기본 Config만 제공 되며, 실제 필요 Config에 맞게 수정 후 배포 필요
<br/>

<br/>

### 2.3. CI/CD 파이프라인
- GitHub Actions를 사용한 자동 빌드 및 배포가 가능한 CI/CD 파이프라인 제공
  - CI 파이프라인은 소스코드 Repository에, CD 파이프라인은 Configuration Repository에 위치
- CTO의 표준 브랜치 및 배포 전략에 준하는 빌드/배포 GitHub Actions Workflow (파이프라인)
  <br/><br/>

## 3. 상세 가이드
| # |구분                    | 상세 가이드 |
|---|-----------------------|----|
| 1 |레이어드 아키텍처 설명         |https://lgu-cto.atlassian.net/wiki/spaces/CLOUDASSET/pages/37449924609/1|
| 2 |CTO 브랜치 및 배포 전략 2.0    |https://lgu-cto.atlassian.net/wiki/spaces/CLOUDASSET/pages/37473818834/CTO+2.0|
| 3 |환경 별 빌드 및 배포 가이드     |https://lgu-cto.atlassian.net/wiki/spaces/CLOUDASSET/pages/37473912656|
| 4 |CI/CD 파이프라인 상세 설명     |https://lgu-cto.atlassian.net/wiki/spaces/CLOUDASSET/pages/37473912120/2.1+APP+CI+CD+Repository|
| 5 |Config Management 가이드      |https://lgu-cto.atlassian.net/wiki/spaces/CNDT/pages/37456709169/01.+Config+Management|
