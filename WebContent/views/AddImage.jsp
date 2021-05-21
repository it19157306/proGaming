<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <link rel="stylesheet" href="css/admin.css">
  <link rel="stylesheet" href="icons/css/all.css">
  <script src="js/admin.js"></script>

  <!-- Font -->
  <link href="https://fonts.googleapis.com/css2?family=Nova+Cut&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Kenia&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Kenia&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Nova+Flat&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500&display=swap" rel="stylesheet">
  

</head>

<body>
  <!-- Admin dashboard -->
  <jsp:include page="adminPanel.jsp"></jsp:include>

  <!-- Admin Content -->
  <div class="main">
    <div class="row">
      <div class="col-xl-2 col-lg-2 col-md-3"></div> <!-- To allocate the space for the admin navigation bar-->
      <!-- content display area -->
      <div class="col-xl-10 col-lg-10 col-md-9 main-screen">
        <!-- Page heading -->
        <h3 class="sect-header">Add Customer</h3>
        <!-- Page navigation -->
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Customer</a></li>
            <li class="breadcrumb-item active" aria-current="page">Add Customer</li>
          </ol>
        </nav>
        <!-- End of Page navigation -->
        <!-- Horizontal rule -->
        <hr class="admin-sect-div mb-4">

        <!-- Form -->
        <div class="admin-form" >
          <form action ="${pageContext.request.contextPath}/ImageController" method = "post" enctype="multipart/form-data">

            <div class="form-row">
              <div class="form-group col-md-6 form-align">
                <label for="Image">Select Image</label>
                <input type="file" class="form-control" id="ImageFile" name="image" >
              </div>
             
            </div>


            <div class="form-group row">
              <div class="col-sm-12 btn-submit-col">
                <button type="submit" class="btn btn-submit">Submit</button>
              </div>
            </div>

          </form>
        </div> <!-- End of admin-form -->
      </div> <!-- End of main screen class -->
    </div> <!-- End of row-->
  </div> <!-- End of main -->



 
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"></script>

</body>
</html>