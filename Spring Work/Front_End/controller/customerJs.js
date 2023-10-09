
  initiateUI();

  function initiateUI() {
  clearAll();
  $("#customerContent").css("display", "block");

  setTheLastView();
}

  function saveLastView(clickedID) {
  switch (clickedID) {
  case "customerContent":
  localStorage.setItem("view", "CUSTOMER");
  break;
  case "itemContent":
  localStorage.setItem("view", "ITEM");
  break;
  case "ordersContent":
  localStorage.setItem("view", "ORDERS");
  break;
  case "placeOrdersContent":
  localStorage.setItem("view", "PLACEORDERS");
  break;
}
}

  function setTheLastView() {
  let view = localStorage.getItem("view");
  switch (view) {
  case "CUSTOMER":
  setView($("#customerContent"));
  break;
  case "ITEM":
  setView($("#itemContent"));
  break;
  case "ORDERS":
  setView($("#ordersContent"));
  break;
  case "PLACEORDERS":
  setView($("#placeOrdersContent"));
  break;
  default:
  setView($("#customerContent"));
}
}



  function setView(viewOb) {
  clearAll();
  viewOb.css("display", "block");
  saveLastView(viewOb.get(0).id);
  console.log(viewOb.get(0).id);
}

  $("#customers").click(function () {
  setView($("#customerContent"));
});

  $("#items").click(function () {
  setView($("#itemContent"));
});

  $("#orders").click(function () {
  setView($("#ordersContent"));
});

  $("#placeOrders").click(function () {
  setView($("#placeOrdersContent"));
});


  const BASE_URL = "http://localhost:8081/java_pos/";


  /*  $("#btnDelete").click(function (){
  getAllCustomer();
  alert("ok");
});*/

  /*  getAllCustomer();

  function getAllCustomer(){
  $("#tblCustomer").empty();
  $.ajax({
  url:"http://localhost:8081/java_pos/test",
  method:"GET",
  headers:{
  Auth:"user=admin,pass=admin"
},
  success:function (res){
  //let customers = cus.data;
  for (let i = 0; i < res.length; i++) {
  let id = res[i].id;
  let name = res[i].name;
  let address = res[i].address;
  let contact = res[i].contact;

  console.log(id,name,address,contact);

  let row = `<tr><td>${id}</td><td>${name}</td><td>${address}</td><td>${contact}</td></tr>`;
  $("#tblCustomer").append(row);
}
},error:function (error){
  console.log(error);
  // alert(error.responseJSON.message);
}

});
}*/

  getAllCustomer();
  function getAllCustomer(){
  $("#tblCus").empty();
  $.ajax({
  url:"http://localhost:8081/java_pos/test",
  method: "GET",
  headers:{
  Auth:"user=admin,pass=admin"
},

  success:function (res){
  let customers = res.data;
  for (let i = 0; i < customers.length; i++) {
  let id = customers[i].id;
  let name = customers[i].name;
  let address = customers[i].address;
  let contact = customers[i].contact;

  // console.log(id,name,address,contact);

  let row = `<tr><td>${id}</td><td>${name}</td><td>${address}</td><td>${contact}</td></tr>`;
  $("#tblCus").append(row);
}
},error:function (error){
  console.log(error);
  // alert(error.responseJSON.message);
}
});
}



  $("#tblCus").on('click',function (event){
  let tr= $(event.target).closest("tr");

  let id = tr.find("td:eq(0)").text();
  let name = tr.find("td:eq(1)").text();
  let address = tr.find("td:eq(2)").text();
  let salary = tr.find("td:eq(3)").text();

  setFiledSet(id,name,address,salary);
  // console.log(id,name,address,salary);
});

  function setFiledSet(id,name,address,salary){
  $("#txtCustomerID").val(id);
  $("#txtCustomerName").val(name);
  $("#txtCustomerAddress").val(address);
  $("#txtCustomerContact").val(salary);
}


  $("#save").click(function (){
  let formData=$("#customerFrom").serialize();
  console.log(formData);

  $.ajax({
  url:BASE_URL+"test",
  method: "POST",
  data:formData,
  headers:{
  Auth:"user=admin,pass=admin"
},
  success:function (res){
  alert("Customer Saved");
  getAllCustomer();
  clearAll();
},error:function (error){
  console.log(error);
  alert(error.responseJSON.message);
}

});
});

  function clearAll(){
  $("#txtCustomerID").val("");
  $("#txtCustomerName").val("");
  $("#txtCustomerAddress").val("");
  $("#txtCustomerContact").val("");
}


  $("#btnUpdate").click(function (){

  let id=$("#txtCustomerID").val();
  let name=$("#txtCustomerName").val();
  let address=$("#txtCustomerAddress").val();
  let contact=$("#txtCustomerContact").val();

  let cusData={
  cusId:id,
  cusName:name,
  cusAddress:address,
  contact:contact
};

  $.ajax({
  url:BASE_URL+"test",
  method:"PUT",
  data:JSON.stringify(cusData),
  contentType:"application/json",
  headers:{
  Auth:"user=admin,pass=admin"
},

  success:function (res){
  alert(res.message);
  getAllCustomer();
  clearAll();

},error:function (error){
  console.log(error);
  alert(error.responseJSON.message);
}
});

});


  $("#btnDelete").click(function (){
  let formData=$("#customerFrom").serialize();
  let id=$("#txtCustomerID").val();
  $.ajax({
  url:BASE_URL+"test?cusId=" + id,
  method:"DELETE",
  data:formData,
  headers:{
  Auth:"user=admin,pass=admin"
},
  success:function (res){
  alert(res.message);
  getAllCustomer();
  clearAll();

},error:function (error){
  console.log(error);
  alert(error.responseJSON.message);
}
});

});









