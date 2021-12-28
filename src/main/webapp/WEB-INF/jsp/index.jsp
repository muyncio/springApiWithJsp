<%@ page language="java" contentType="text/html;charset=UTF-8;  charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" />
    <link rel="stylesheet" href="css/style.css">
    <title>Index</title>
</head>
<body>
<div class="container-md">
    <div class="row">
        <div class="col-md-10"></div>
        <div class="col-md-2">
            <script type="text/javascript">
                document.write(new Date().toLocaleString().replace(",","").replace(/:.. /," "));
            </script>
        </div>
    </div>

    <h1>Co chcesz zrobic?</h1>
    <div class="row justify-content-md-center">
        <div class="col-md-4">
            <a href="./table"><button type="button " class="btn btn-dark btn-lg btn-block">Tabela ze wszystkimi wartosciami</button></a>
        </div>
        <div class="col-md-4">
            <a href="tablewiththesame"><button type="button" class="btn btn-dark btn-lg btn-block">Tabela z powtarzajacymi sie wartosciami</button></a>
        </div>
        <div class="col-md-4">
            <a href="tablewithdifferent"><button type="button" class="btn btn-dark btn-lg btn-block">Tabela z nie powtarzajacymi sie wartosciami</button></a>
        </div>
    </div>
</div>

<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"></script>
</body>
</html>
