<%@page import="java.util.ArrayList"%>
<%@page import="model.TheLoai"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card mb-3">
    <h3 class="card-header">category</h3>  
    <div class="list-group">
        <%
            ArrayList<TheLoai> listTheLoai = (ArrayList<TheLoai>)request.getAttribute("listTheLoai");
            Integer maLoaiSelected = (Integer)request.getAttribute("maLoaiSelected");
            if (listTheLoai != null) {
                for(TheLoai tl : listTheLoai) {
                    String active = "";
                    if (maLoaiSelected != null && tl.getMaLoai() == maLoaiSelected) {
                        active = "active";
                    }
        %>
        <a href="san-pham?maloai=<%=tl.getMaLoai()%>" 
           class="list-group-item list-group-item-action <%=active%>">
            <i class="bi bi-arrow-right-circle"></i> <%=tl.getTenLoai()%>
        </a>
        <%
                }
            }
        %>
    </div>
</div>