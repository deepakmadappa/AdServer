$(function() {

	var categoriesDisplayed = [];
	var c = $('.filterOptions');
	for (var i = 0; i < c.length; i++) {
		if ($(c[i]).val() == "Show All")
			continue;
		categoriesDisplayed.push($(c[i]).val());
	}

	$('.filterOptions').click(function() {
		if (this.value == "Show All") {
			$('.searchResult').show();
			return;
		}
		var a = jQuery.inArray(categoriesDisplayed, this.value);
		categoriesDisplayed = jQuery.grep(y, function(value) {
			return value != this.value;
		});
		if (this.checked) {
			
		}
		displayCategories(categoriesDisplayed);
	});
});

function displayCategories(categories) {
	var searchResults = $('.searchResult');
	for(var i = 0; i < searchResults.length; i++){
		if($(searchResults[i]).children('input').val())
	}
}