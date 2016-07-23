<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Top Vakantie - Koksijde</title>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style/desktop.css" media="only screen">
    <link rel="stylesheet" type="text/css" href="style/mobile-portrait.css"
          media="all  and (orientation: portrait)">
</head>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick.min.js"></script>
<body>
<!-- main page -->
<?php include 'elements/menubar.php'; ?>
<div id="page_1">
    <h1 class="title">
        Top Vakantie - Koksijde
    </h1>
</div>
<div id="page_2">
    <h1 class="title">
        Het kader
    </h1>
    <ul>
        <!-- todo: lijst kaderleden + foto's -->
        <li></li>
    </ul>
</div>
<div id="page_3">
    <h1 class="title">
        Het domein
    </h1>
    <div class="carousel_domein">
        <div><img src="img-src/T_gebouw.png">T - de eetplaats</div>
        <div><img src="img-src/bronne_gebouw.png">De Bronne - het studiegebouw</div>
    </div>
    <!-- todo: foto's domein -->
    <script type="text/javascript">
        $(document).ready(function () {
            $('.carrousel_domein').slick({
                centerMode: true,
                centerPadding: '60px',
                slidesToShow: 3,
                responsive: [
                    {
                        breakpoint: 768,
                        settings: {
                            arrows: false,
                            centerMode: true,
                            centerPadding: '40px',
                            slidesToShow: 3
                        }
                    },
                    {
                        breakpoint: 480,
                        settings: {
                            arrows: false,
                            centerMode: true,
                            centerPadding: '40px',
                            slidesToShow: 1
                        }
                    }
                ]
            });
        });
    </script>
</div>
<div id="page_4">

</div>
<div id="page_5">
    <h1 class="contact">
        Contact
    </h1>
    <p>
        Hotelschool Ter Duinen<br>
        t.a.v. &lt;naam&gt; (Top Vakantie)<br>
        Houtsaegerlaan 40<br>
        8670 Koksijde
    </p>
    <p>
        <a href="mailto:koksijde@topvakantieacademie.be">koksijde@topvakantieacademie.be</a>
    </p>
</div>
</body>
</html>