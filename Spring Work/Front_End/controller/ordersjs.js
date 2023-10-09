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

function clearAll() {
  $("#customerContent,#itemContent,#ordersContent,#placeOrdersContent").css('display', 'none');
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




