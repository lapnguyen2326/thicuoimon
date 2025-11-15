<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="model.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--nhung noi dung header.jsp-->
<jsp:include page="shared/header.jsp" />
<!--nhung noi dung nav.jsp-->
<jsp:include page="shared/nav.jsp" />
<section class="bg-body-secondary text-center">
    <div class="container">
        <h1 class="jumbotron-heading text-muted">Shoes Store</h1>
        <p class="lead text-muted mb-0">CHUYÊN CUNG CẤP GIÀY THỂ THAO SỐ 1 TẠI VIỆT NAM</p>
    </div>
</section>

<div class="container" id="main-content">
    <div class="row">       
        <div class="col-sm-12">
            <h4 class="alert alert-primary">Sản phẩm khuyến MÃI </h4>
            <div class="row">   
                <%
                    ArrayList<SanPham> listSanPham = (ArrayList<SanPham>)request.getAttribute("listSanPham");
                    DecimalFormat fmt = new DecimalFormat("#,##0");

                    if (listSanPham != null) {
                        // Sắp xếp danh sách sản phẩm theo giá tăng dần
                        Collections.sort(listSanPham, new java.util.Comparator<SanPham>() {
                            public int compare(SanPham sp1, SanPham sp2) {
                                return Double.compare(sp1.getDonGia(), sp2.getDonGia());
                            }
                        });

                        // Hiển thị các sản phẩm đã sắp xếp
                        for(SanPham sp : listSanPham) {
                %>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card mb-2">
                        <div class="card-header">
                            <%=sp.getTenSP()%>
                        </div>
                        <div class="card-body">
                            <img class="card-img" src="assets/images/products/<%=sp.getHinh()%>" alt="Card image cap">                         
                        </div>
                        <div class="card-footer">
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block"><%=fmt.format(sp.getDonGia())%> đ</p>
                                </div>
                                <div class="col text-end">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>              
                </div>
                <%
                        }
                    }
                %>
            </div>                       
        </div>
    </div>
</div><!-- /.container -->

<!--nhung noi dung footer.jsp-->
<jsp:include page="shared/footer.jsp" />
