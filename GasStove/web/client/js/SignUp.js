$(document).ready(function () {


$("#submit-btnSignUp").on("click", () => {
        checkForm()
    });
    checkName = () => {
// name empty
        if ($("#nameId").val() == "") {
            $("#textDanger-name").text("Name could not be empty!")
        } else {
            $("#textDanger-name").text("");
            return 1;
        }
    }


    checkName = () => {
// name empty
        if ($("#nameId").val() == "") {
            $("#textDanger-name").text("Name could not be empty!")
        } else {
            $("#textDanger-name").text("");
            return 1;
        }
    };


    checUserName = () => {
// user name empty
        if ($("#userNameId").val() == "") {
            $("#textDanger-userName").text("User name could not be empty!")
        } else if ($("#userNameId").val() != "") {
            $("#textDanger-userName").text("")
        }
//  length of user name > 10
        if ($("#userNameId").val().length > 10) {
            $("#textDanger-userName").text("Length of user name must be < 10")
        } else {
            return 1;
        }
    }

    checkPassWord = () => {
// pass empty
        if ($("#passwordId").val() == "") {
            $("#textDanger-passWord").text("Pass could not be empty!")
        } else if ($("#passwordId").val() != "") {
            $("#textDanger-passWord").text("")
        }

// repass empty
        if ($("#rePassWordId").val() == "") {
            $("#textDanger-rePassWord").text("RePass could not be empty!")
        } else if ($("#rePassWordId").val() != "") {
            $("#textDanger-rePassWord").text("")
        }


        if ($("#passwordId").val() != '' && $("#rePassWordId").val() != '') {

// pass must be match format
            if (!/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/.test($("#passwordId").val())) {
                $("#textDanger-passWord").text("Length 6-20 char and from a-z")
            } else {
                $("#textDanger-passWord").text("")
            }

// pas and repass are not equals 
            if ($("#rePassWordId").val() != $("#passwordId").val()) {
                $("#textDanger-rePassWord").text("RePass not equals pass ")
            } else {
                $("#textDanger-rePassWord").text("")
                return 1;
            }
        }
    }

    checkEmail = () => {
// email empty
        if ($("#emailId").val() == "") {
            $("#textDanger-email").text("Email could not be empty!")
        } else if ($("#emailId").val() != "") {
            $("#textDanger-email").text("")
            // email must be right format
            if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($("#emailId").val())) {
                $("#textDanger-email").text("Email must be like 'name@example'")
            } else {
                return 1;
            }
        }
    }

    checkPhoneNumber = () => {
        if ($("#phoneNumber").val() == "") {
            $("#textDanger-phone").text("Phone could not be empty!")
        } else if ($("#phoneNumber").val() != "") {
            $("#textDanger-phone").text("")
            // email must be right format
            if (!/(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/.test($("#phoneNumber").val())) {
                $("#textDanger-phone").text("This not is phone number")
            } else {
                return 1;
            }
        }
    }

//     checkAddressDetails = () => {
// // address name empty
//         if ($("#addressDetailsId").val() == "") {
//             $("#textDanger-addressDetails").text("Address could not be empty!")
//         } else if ($("#addressDetailsId").val() != "") {
//             $("#textDanger-addressDetails").text("")
//         }
// //  length of address > 10
//         if ($("#addressDetailsId").val().length < 10) {
//             $("#textDanger-addressDetails").text("Length of address must be > 10")
//         } else {
//             return 1;
//         }
//     };
    checkCity = () => {
// address name empty
        if ($("#cityId").val() == "") {
            $("#textDanger-city").text("City could not be empty!")
        } else if ($("#cityId").val() != "") {
            $("#textDanger-city").text("")
            return 1;
        }
    }

    checkDistrict = () => {
// address name empty
        if ($("#districtId").val() == "") {
            $("#textDanger-district").text("District could not be empty!")
        } else if ($("#districtId").val() != "") {
            $("#textDanger-district").text("")
            return 1;
        }
    }

    checkForm = () => {
        let name = checkName();
        let userName = checUserName();
        let passWord = checkPassWord();
        let email = checkEmail();
        let phoneNumber = checkPhoneNumber();
        let city = checkCity();
        let district = checkDistrict();
        // all fileds are equ al format and not empty
        if (name == 1 && userName == 1 && passWord == 1 && email == 1 && phoneNumber == 1  && city == 1 && district == 1) {
            $("#signUpForm").submit();
        }
    };
    var renderData = (array, select) => {
        let row = ' <option value="">chọn</option>';
        // display all province
        array.forEach(element => {
            row += `<option value="${element.code}">${element.name}</option>`
        });
        document.querySelector("#" + select).innerHTML = row
    }

    var callAPI = (api) => {
        return axios.get(api)
                .then((response) => {
                    renderData(response.data, "cityId");
                });
    }

    callAPI('https://provinces.open-api.vn/api/?depth=1');
    var callApiDistrict = (api) => {
        return axios.get(api)
                .then((response) => {
                    renderData(response.data.districts, "districtId");
                });
    }

// url to get API
    const host = "https://provinces.open-api.vn/api/";
    $("#cityId").change(() => {
        callApiDistrict(host + "p/" + $("#cityId").val() + "?depth=2");
        console.log($("#inputl").val())
    });
    $("#districtId").change(() => {
        printResult();
    });
    var printResult = () => {
        if ($("#districtId").val() != "" && $("#cityId").val()) {
            let city = $("#cityId option:selected").text();
            let distric = $("#districtId option:selected").text();
            // $("#result").text(pro + ", " + distric)
            document.getElementById('city').value = city;
            document.getElementById('district').value = distric;
        }
    }

    
});
$(document).ready(function() {
        $("#datepicker").datepicker();
      });