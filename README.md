# SoftpalGridView


### Developed by
[Softpal](https://www.github.com/softpal)

### ExpandableGridView

This is a customized Android expandable GridView.


## Installation

Add repository url and dependency in application module gradle file:
  
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  ### Gradle
[![](https://jitpack.io/v/softpal/SoftPalGridView.svg)](https://jitpack.io/#softpal/SoftPalGridView)
```javascript
dependencies {
    implementation 'com.github.softpal:SoftPalGridView:1.0'
}
```

## Usage

Include the class ExpandableGridView.java in your project.

## 1.Adding ExpandableGridViewLayout in Your XMl file.

    <com.softpal.expandableheightgridview.ExpandableHeightGridView
        android:id="@+id/simpleGridView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:footerDividersEnabled="false"
        android:horizontalSpacing="5dp"
        android:isScrollContainer="true"
        android:nestedScrollingEnabled="true"
        android:numColumns="2"
        android:padding="1dp"
        android:stretchMode="columnWidth"
        android:verticalSpacing="10dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
        
   ### 1. Calling  ExpandableGridView Class
   
   
        public class ExpandableHeightGridView extends GridView
{
	/**
	 The Expanded.
	 */
	boolean expanded = false;
	
	/**
	 Instantiates a new Expandable height grid view.
	 
	 @param context the context
	 */
	public ExpandableHeightGridView(Context context)
	{
		super(context);
	}
	
	/**
	 Instantiates a new Expandable height grid view.
	 
	 @param context the context
	 @param attrs   the attrs
	 */
	public ExpandableHeightGridView(Context context,AttributeSet attrs)
	{
		super(context,attrs);
	}
	
	/**
	 Instantiates a new Expandable height grid view.
	 
	 @param context  the context
	 @param attrs    the attrs
	 @param defStyle the def style
	 */
	public ExpandableHeightGridView(Context context,AttributeSet attrs,int defStyle)
	{
		super(context,attrs,defStyle);
	}
	
	@Override
	public void onMeasure(int widthMeasureSpec,int heightMeasureSpec)
	{
		// HACK! TAKE THAT ANDROID!
		if(isExpanded())
		{
			// Calculate entire height by providing a very large height hint.
			// View.MEASURED_SIZE_MASK represents the largest height possible.
			int expandSpec = MeasureSpec.makeMeasureSpec(MEASURED_SIZE_MASK,MeasureSpec.AT_MOST);
			super.onMeasure(widthMeasureSpec,expandSpec);
			
			ViewGroup.LayoutParams params = getLayoutParams();
			params.height = getMeasuredHeight();
		}
		else
		{
			super.onMeasure(widthMeasureSpec,heightMeasureSpec);
		}
	}
	
	/**
	 Is expanded boolean.
	 
	 @return the boolean
	 */
	public boolean isExpanded()
	{
		return expanded;
	}
	
	/**
	 Sets expanded.
	 
	 @param expanded the expanded
	 */
	public void setExpanded(boolean expanded)
	{
		this.expanded = expanded;
	}

        
  ### 2. Getting ExpandableGridView in your Fragment.
        
       
final ExpandableHeightGridView gridView = view.findViewById(R.id.simpleGridView);




