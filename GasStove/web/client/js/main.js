(function ($) {
    "use strict";
    
    // Dropdown on mouse hover
    $(document).ready(function () {
        function toggleNavbarMethod() {
            if ($(window).width() > 992) {
                $('.navbar .dropdown').on('mouseover', function () {
                    $('.dropdown-toggle', this).trigger('click');
                }).on('mouseout', function () {
                    $('.dropdown-toggle', this).trigger('click').blur();
                });
            } else {
                $('.navbar .dropdown').off('mouseover').off('mouseout');
            }
        }
        toggleNavbarMethod();
        $(window).resize(toggleNavbarMethod);
    });
    
    
    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Vendor carousel
    $('.vendor-carousel').owlCarousel({
        loop: true,
        margin: 29,
        nav: false,
        autoplay: true,
        smartSpeed: 1000,
        responsive: {
            0:{
                items:2
            },
            576:{
                items:3
            },
            768:{
                items:4
            },
            992:{
                items:5
            },
            1200:{
                items:6
            }
        }
    });


    // Related carousel
    $('.related-carousel').owlCarousel({
        loop: true,
        margin: 29,
        nav: false,
        autoplay: true,
        smartSpeed: 1000,
        responsive: {
            0:{
                items:1
            },
            576:{
                items:2
            },
            768:{
                items:3
            },
            992:{
                items:4
            }
        }
    });

function updateQuantity(productId, newQuantity) {
  $.ajax({
    url: "/GasStove/updateCartController",
    method: "POST",
    data: { productId: productId, quantity: newQuantity },
    success: function(response) {
      // Xử lý phản hồi từ server (nếu cần)
    },
    error: function(xhr, status, error) {
      // Xử lý lỗi (nếu có)
    }
  });
}

//Product Quantity
$('.quantity button').on('click', function () {
  var button = $(this);
  var quantityInput = button.parent().siblings('input');
  var totalPriceElement = button.parents('tr').find('#totalPrice');
  var productId = button.parents('tr').find('input[name="itemID"]').val();

  var oldValue = parseFloat(quantityInput.val());
  //var unitPrice = parseFloat(button.parents('tr').find('.align-middle').eq(1).text());
  var unitPriceElement = button.parents('tr').find('.align-middle').eq(1);
  var unitPriceText = unitPriceElement.text();
  var unitPrice = parseFloat(unitPriceText.replace(/,/g, ''));
  if (button.hasClass('btn-plus')) {
    var newVal = oldValue + 1;
  } else {
    if (oldValue > 0) {
      var newVal = oldValue - 1;
    } else {
      newVal = 0;
    }
  }

  quantityInput.val(newVal);
  updateTotalPrice(newVal, unitPrice, totalPriceElement);
  console.log("Calling updateQuantity with productId: " + productId + ", newVal: " + newVal);
  // Gọi hàm updateQuantity() để gửi yêu cầu cập nhật số lượng sản phẩm lên Servlet
  updateQuantity(productId, newVal);
});

    // Hàm cập nhật giá trị tổng
    function updateTotalPrice(quantity, unitPrice, totalPriceElement) {
      var totalPrice = quantity * unitPrice;
      totalPrice = Math.floor(totalPrice); // Làm tròn tổng xuống số nguyên
      var formattedTotalPrice = totalPrice.toLocaleString();
      totalPriceElement.text(formattedTotalPrice);
    }

})(jQuery);

