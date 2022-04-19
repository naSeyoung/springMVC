<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> //꼭넣어주기
<%
    //request, response 는 그냥 사용 가능 jsp는 서블릿이 자동 변환 ==> 로직이 자동사용가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>
    성공
    <ul>
        <li> id=<%=member.getId()%></li>
        <li>    age=<%=member.getAge()%></li>
        <li>    username=<%=member.getUsername()%></li>


        <a href="/index.html">메인</a>

    </ul>
</form>
</body>
</html>