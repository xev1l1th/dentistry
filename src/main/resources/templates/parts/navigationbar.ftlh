<link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.min.css">
<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Dentistry</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbar-example" aria-controls="navbar-example"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- Основная часть меню (может содержать ссылки, формы и другие элементы) -->
        <div class="collapse navbar-collapse" id="navbar-example">
            <!-- Этот блок расположен слева -->
            <ul class="navbar-nav mr-auto">
                <!--
                <li class="nav-item active">
                    <a class="nav-link" href="#">Справочники <span class="sr-only"></span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Документы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Отчеты</a>
                </li>
                -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                       role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        Справочники
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/workschedule">Виды графиков работ</a>
                        <a class="dropdown-item" href="/income">Виды доходов и расходов</a>
                        <!--
                        <div class="dropdown-divider"></div>
                        -->
                        <a class="dropdown-item" href="/contracts">Договоры</a>
                        <a class="dropdown-item" href="/contractors">Контрагенты</a>
                        <a class="dropdown-item" href="/organization">Организации</a>
                        <a class="dropdown-item" href="/warehouse">Склады</a>
                        <a class="dropdown-item" href="/employee">Сотрудники</a>
                        <a class="dropdown-item" href="/country">Страны</a>
                        <a class="dropdown-item" href="/product">Товары</a>
                        <a class="dropdown-item" href="/services">Услуги</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                       role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        Документы
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/contrproductprices">Ввод цен поставщиков</a>
                        <!--
                        <div class="dropdown-divider"></div>
                        -->
                        <a class="dropdown-item" href="/servicedelivery">Оказание услуг</a>
                        <a class="dropdown-item" href="/receipt">Поступление товара</a>
                        <a class="dropdown-item" href="/sale">Продажа товара</a>
                        <a class="dropdown-item" href="/saleprices">Установк цен на товары</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                       role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        Отчеты
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/productremnant">Остатки товаров</a>
                        <a class="dropdown-item" href="/contractorprice">Закупочные цены</a>
                        <!--
                        <div class="dropdown-divider"></div>
                        -->
                        <a class="dropdown-item" href="/orgprices">Прайс лист товаров</a>
                    </div>
                </li>
            </ul>
            <!-- Этот блок расположен справа
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
            </form>
            --->
        </div>
    </div>
</nav>
