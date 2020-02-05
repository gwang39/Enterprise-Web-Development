/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This function validates party size, start date, duration input in the quote form
 * @returns {Boolean}
 */

function validation() 
{
    var year = document.forms["queryForm"]["year"].value;
    var month = document.forms["queryForm"]["month"].value;
    var day = document.forms["queryForm"]["day"].value;
   

        if(year > 2004 && year < 2021 && month > 0 && month < 13 && day >0 && day <32)
         {// check start date

                 return true;
         }

         else
         {
             alert("Invalid Date: Please Check Start Date");
             return false;
         }


}