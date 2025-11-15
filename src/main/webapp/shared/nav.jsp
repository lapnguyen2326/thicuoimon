<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String uri = request.getRequestURI();
    String trangChuClass = "";
    String sanPhamClass = "";
    
    if (uri.contains("trang-chu") || uri.endsWith("/") || uri.equals(request.getContextPath() + "/")) {
        trangChuClass = "active";
    } else if (uri.contains("san-pham")) {
        sanPhamClass = "active";
    }
%>
<nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
  <div class="container">
    <a class="navbar-brand" href="trang-chu">Shoes Store</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link <%=trangChuClass%>" href="trang-chu">Trang chủ </a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%=sanPhamClass%>" href="san-pham">Sản phẩm</a>
        </li>         
     
    </div>
  </div>
</nav>