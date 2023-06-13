<#include "secur.ftlh">

<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <script src="https://kit.fontawesome.com/e330946565.js" crossorigin="anonymous"></script>
        <meta charset="UTF-8"/>
        <title>Аптека</title>
        <link ref="stylesheet" href="style.css" />

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

        <!-- 1. Подключить CSS-файл Bootstrap 3 -->
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <!-- 2. Подключить CSS-файл библиотеки Bootstrap 3 DateTimePicker -->
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />

        <!-- 3. Подключить библиотеку jQuery -->
        <script src="js/jquery.min.js"></script>
        <!-- 4. Подключить библиотеку moment -->
        <script src="js/moment-with-locales.min.js"></script>
        <!-- 5. Подключить js-файл фреймворка Bootstrap 3 -->
        <script src="js/bootstrap.min.js"></script>
        <!-- 6. Подключить js-файл библиотеки Bootstrap 3 DateTimePicker -->
        <script src="js/bootstrap-datetimepicker.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"/>
        <script src="https://www.google.com/recaptcha/api.js" async="defer"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/turbolinks/5.2.0/turbolinks.js"></script>
        <script src = "https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        </script>
    </head>
    <body>
    <#include "navigationbar.ftlh">
    </br>
    <#nested>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>