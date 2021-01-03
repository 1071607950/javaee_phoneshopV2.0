<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jQuery 2.2.3 -->
<script src="/Phoneshop/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/Phoneshop/bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="/Phoneshop/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/Phoneshop/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/Phoneshop/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/Phoneshop/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/Phoneshop/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/Phoneshop/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>