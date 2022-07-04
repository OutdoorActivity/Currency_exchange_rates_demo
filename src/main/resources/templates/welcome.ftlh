<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome page</title>
</head>
<body>
<h3>Добро пожаловать!</h3>
<form action="/v1/difference" method="GET">
    <table border="1px">
        <tr>
            <td>
                <label>Дата(гггг-мм-дд.json)</label>
                <input type="text" name="date">
            </td>


            <td>
                <label>App_ID</label>
                <input type="text" name="app_id">
            </td>
            <td>
                <label>Валюта</label>
                <input type="text" name="symbols">
            </td>
        </tr>
    </table>
    <td>
        <input type="submit" value="подтвердить данные">
    </td>
</form>
</body>
</html>