import React, { useState, useEffect } from 'react';

function MyURLs() {
  const [urls, setUrls] = useState([]);

  useEffect(() => {
    // Placeholder: You'll fetch data from your API or data store 
    const fetchData = async () => {
      // Replace with your actual data fetching logic
      const response = await fetch('/api/my-urls'); 
      const data = await response.json();
      setUrls(data); 
    };

    fetchData();
  }, []); 

  return (
    <div className="my-urls-container">
      <h2>My Shortened URLs</h2>
      {urls.length === 0 ? (
        <p>You don't have any shortened URLs yet.</p>
      ) : (
        <ul>
          {urls.map((url) => (
            <li key={url.id}>
              {/* Replace with how you want to display  */}
              <p>Original URL: {url.originalUrl}</p>
              <p>Shortened URL: <a href={url.shortenedUrl}>{url.shortenedUrl}</a></p>

              {/* Add QRCode, SocialShare, Copy as needed */} 
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default MyURLs;
