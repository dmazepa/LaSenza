Meta:

Narrative:
Allow customers shopping from different countries.

Scenario: I should see in dependent of my IP special version of site.
Given I open home page with IP from USA
Then I should see US/English version of the site.
Then Prices set for US/English version of the site.
Then Products set for US/English version of the site.
Then Promotions set for US/English version of the site.

Scenario:  I should redirects to UK version of site with UK IP.
Given I open home page with UK IP.
Then I should see UK LaSenza site.

Scenario: I can change the version of the site.
Given I am on home page.
Then I sould see default location "ca_en"

Scenario: I can change the version of the site.
Given I am on home page.
When I choose <siteVersion> version of site.
Then I should see <siteVersion> version of site.


Examples:
|siteVersion
|us_en
|ca_fr