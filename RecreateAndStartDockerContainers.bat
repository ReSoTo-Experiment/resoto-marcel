@echo off
:: Script to build a Docker image


:: Default values
set TAG=0.0
set DIR=.

echo clean up
docker-compose down
docker rmi resoto/surveyhandler:%TAG%
docker rmi resoto/surveymanager:%TAG%


echo Building Docker image resoto/surveyhandler:%TAG% from directory %DIR%...
cd surveyhandler
docker build -t resoto/surveyhandler:%TAG% %DIR%

if %ERRORLEVEL%==0 (
    echo Docker image resoto/surveyhandler:%TAG% built successfully.
) else (
    echo Error: Failed to build Docker image %NAME%:%TAG%.
    exit /b 1
)

cd ..

echo Building Docker image resoto/surveymanager:%TAG% from directory %DIR%...
cd surveymanager
docker build -t resoto/surveymanager:%TAG% %DIR%

if %ERRORLEVEL%==0 (
    echo Docker image resoto/surveymanager:%TAG% built successfully.
) else (
    echo Error: Failed to build Docker image %NAME%:%TAG%.
    exit /b 1
)

echo starting platform
cd ..
docker-compose up