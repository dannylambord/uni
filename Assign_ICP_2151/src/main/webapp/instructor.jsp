<html>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta name="GENERATOR" content="Microsoft FrontPage 4.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<title>New Page 1</title>
</head>
    <body>
        <form method="post" action="insertServlet">
            <p>Question: <input type="text" name="question" size="50"></p>
            <p>Answer 1: <input type="text" name="ans1" size="20"></p>
            <p>Answer 2: <input type="text" name="ans2" size="20"></p>
            <p>Answer 3: <input type="text" name="ans3" size="20"></p>
            <p>Answer 4: <input type="text" name="ans4" size="20"></p>
            <p>Correct answer: <input type="text" name="correctAns" size="20"></p>
            <p>  <input type="submit" value="Insert" name="B1"></p>
        </form>
        
        <form method="post" action="DeleteServlet">
            <p>Question to be deleted: <input type="text" name="word" size="50"></p>
            <p>  <input type="submit" value="Delete" name="B1"></p>
        </form>

        <form method="post" action="UpdateServlet">
            <p>Current question: <input type ="text" name ="currentQues" size ="50"></p>
            <p>Question: <input type="text" name="nQuestion" size="50"></p>
            <p>Answer 1: <input type="text" name="nAns1" size="20"></p>
            <p>Answer 2: <input type="text" name="nAns2" size="20"></p>
            <p>Answer 3: <input type="text" name="nAns3" size="20"></p>
            <p>Answer 4: <input type="text" name="nAns4" size="20"></p>
            <p>Correct answer: <input type="text" name="nCorrectAns" size="20"></p>
            <p>  <input type="submit" value="Update" name="B1"></p>
        </form>
    </body>
</html>