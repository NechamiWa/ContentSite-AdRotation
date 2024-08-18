# ContentSite-AdRotation

## Project Overview
ContentSite-AdRotation is a Spring Boot-based server-side application designed to manage and display rotating advertisements on a content website. It offers a system where advertisers can purchase ad space either based on time or number of views, ensuring that ads are shown in predefined areas such as the top, left, right, and bottom of the page.

### Key Features
- **Ad Management**: Support for both time-based and view-based advertisements.
- **Ad Space Allocation**: Ads are dynamically allocated to available areas on the site.
- **PNG Image Ads**: All advertisements are uploaded as PNG images, making them compatible with various web displays.
- **Advertiser Authentication**: Existing advertisers can log in to purchase ad slots and manage their ads.
- **Automatic Ad Scheduling**: Ads are automatically deactivated based on the number of views or the duration specified during the purchase.
  
### Advertisement Types
1. **Time-Based Ads**: Advertisements that are displayed for a specific amount of time (in minutes). The advertiser defines the time period, and the ad is automatically removed after that time has passed.
2. **View-Based Ads**: Advertisements that are displayed a set number of times, with each view counted. Once the ad reaches the specified number of views, it is automatically deactivated.

Each ad space has its own size constraints and availability. Advertisers can choose which area to display their ads in, provided it is available.

### Technologies Used
- **Java**: Core programming language.
- **Spring Boot**: Framework used to build the server-side functionality.
  
### How It Works
- Advertisers log in to the system to purchase ad slots.
- Ads can be uploaded as PNG images and are displayed in one of the four areas of the site.
- Advertisements are managed either by time duration or by number of views.
- Ads are automatically removed from the site when they expire or reach the maximum number of views, and the ad space is freed for the next advertiser.

### Getting Started
1. Clone the repository and install the dependencies.
2. Configure the application properties for your database connection and file storage.
3. Run the Spring Boot application.

