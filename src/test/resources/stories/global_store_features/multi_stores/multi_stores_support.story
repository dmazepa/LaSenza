Meta:

Narrative:
Allow customers shopping from different countries.

Scenario: (GSF09) I can see default version of the site.
Given I am on home page.
Then I sould see default location "ca_en"

Scenario: (GSF08) I can change the version of the site.
Given I am on home page
When I choose <siteVersion> version of site.
Then I should see <siteVersion> version of site.

Examples:
|siteVersion
|us_en
|ca_fr